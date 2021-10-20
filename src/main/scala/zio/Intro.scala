package zio

// ---- THEORY

// EFFECT PATTERN
// computation + sideeffect e.g
//{
//  println("ok")
//  32
//}

// more friendly for ZIO apps
object Intro extends zio.App {

  // SUBSTITUTION MODEL:
  val value = {
    println("ok")
    32
  }
  def incr(i: Int) = i + 1
  incr(42) == incr(value) // NOT REALLY EQUAL
  // This is cornerstone of FP, and in Cats this situation (produced value with side effects),
  // is dedicated to IO Monads

  // ZIO[R, E, A]
  // R - environment, E - error, A - element type

  // simplest case:
  val x: ZIO[Any, Nothing, Int] = ZIO.succeed(42)

  //--------------------------------------------------------------

  // CONCURRENCY examples

  // This shall be sync processes:
  val shower = ZIO.succeed("Taking shower")
  val boilingWater = ZIO.succeed("Boiling water")
  val prepCofee = ZIO.succeed("preparing cofee")

  def printThread = s"[${Thread.currentThread().getName}]"

  // #1 sync
  def syncRutine() = for {
    _ <- shower.debug(printThread)
    _ <- boilingWater.debug(printThread)
    _ <- prepCofee.debug(printThread)
  } yield ()
  // same thread in order
  //[zio-default-async-1]: Taking shower
  //[zio-default-async-1]: Boiling water
  //[zio-default-async-1]: preparing cofee

  // now to CONCURRENCY
  // fiber - it is data structure for scheduled computation
  // Fiber[E, A]
  // #2 async
  def asyncRutine() = for {
    _ <- shower.debug(printThread).fork
    _ <- boilingWater.debug(printThread).fork
    _ <- prepCofee.debug(printThread).fork
  } yield ()
  // now each line was evaluated in separate thread, but not in order
  //[zio-default-async-3]: Boiling water
  //[zio-default-async-4]: preparing cofee
  //[zio-default-async-2]: Taking shower

  // #3 asyn with order
  def asyncFiberRutine() = for {
    showerFiber <- shower.debug(printThread).fork
    boilingWaterFiber <- boilingWater.debug(printThread).fork

    // =
    zippeFiber = showerFiber.zip(boilingWaterFiber)

    zippedFiberResult <- zippeFiber.join.debug(printThread)

    // *> and then. It tells do that on same thread
    _ <- ZIO.succeed(s"$zippedFiberResult done").debug(printThread) *> prepCofee.debug(printThread)

  } yield ()
  //[zio-default-async-2]: Taking shower
  //[zio-default-async-3]: Boiling water
  //[zio-default-async-6]: (Taking shower,Boiling water)
  //[zio-default-async-6]: (Taking shower,Boiling water) done
  //[zio-default-async-6]: preparing cofee

  // INTERRUPTION ----

  // Fiber can be interrupted. It is a cheap operation versus JVM thread interuption

  //import ZIO.duration._ lovercases
  import zio.duration._

  val recieveCall = ZIO.succeed("Call from Aice")
  val longBoilingWater = boilingWater.debug(printThread) *> ZIO.sleep(5.seconds) *> ZIO.succeed("Boiled water ready")

  def concurrentRouteWithInteraction() = for {
    _ <- shower.debug(printThread)
    boilingWaterFiber <- longBoilingWater.fork                                           // (!)
    _ <- recieveCall.debug(printThread).fork *> ZIO.sleep(2.seconds) *> boilingWaterFiber.interrupt.debug(printThread)
    _ <- ZIO.succeed("Going with Alice").debug(printThread)
  } yield ()
  //[zio-default-async-1]: Taking shower
  //[zio-default-async-3]: Call from Aice
  //[zio-default-async-2]: Boiling water
  //[zio-default-async-6]: Failure(Traced(Interrupt(Id(1634727887748,1)),ZTrace(Id(1634727887852,2),List(SourceLocation(package ...
  //[zio-default-async-6]: Going with Alice

  // UNINTERRUPTIBLE FIBER ----

  val longCofeePreperation = prepCofee.debug(printThread) *> ZIO.sleep(5.seconds) *> ZIO.succeed("Cofee ready")

  def concurrentRouteWithUninterruptableFiber() = for {
    _ <- shower.debug(printThread)
    _ <- boilingWater.debug(printThread)                      // (!)
    cofeeFiber <- longCofeePreperation.debug(printThread).fork.uninterruptible
    ressult <- recieveCall.debug(printThread).fork *> cofeeFiber.interrupt.debug(printThread)
    _ <- ressult match {
      case Exit.Success(_) => ZIO.succeed("Sorry, breakfest at home").debug(printThread)
      case _ => ZIO.succeed("Failed, going with Alica").debug(printThread)
     }
  } yield ()
  //[zio-default-async-1]: Taking shower
  //[zio-default-async-1]: Boiling water
  //[zio-default-async-2]: preparing cofee
  //[zio-default-async-3]: Call from Aice
  //[zio-default-async-4]: Cofee ready
  //[zio-default-async-5]: Success(Cofee ready)
  //[zio-default-async-5]: Sorry, breakfest at home

  // RUNNER
  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = concurrentRouteWithUninterruptableFiber().exitCode
}
