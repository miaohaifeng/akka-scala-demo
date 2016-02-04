package com.mad.actors

import akka.actor.{Actor, Props}
import com.mad.messages.Result

/**
 * Created by miaohaifeng
 * on 2016/2/4.
 */
class MasterActor extends Actor {
  val aggregateActor = context.actorOf(Props[AggregateActor], name = "aggregate")
  val reduceActor = context.actorOf(Props(classOf[ReduceActor], aggregateActor), name = "reduce")
  val mapActor = context.actorOf(Props(classOf[MapActor], reduceActor), name = "map")

  override def receive: Receive = {
    case msg: String =>
      mapActor ! msg
    case Result() =>
      aggregateActor ! Result()
    case _ =>
  }
}
