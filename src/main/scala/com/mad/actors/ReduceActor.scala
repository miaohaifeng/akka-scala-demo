package com.mad.actors

import akka.actor.{Actor, ActorRef}
import com.mad.messages.{MapData, ReduceData, WordCount}

/**
 * Created by miaohaifeng
 * on 2016/2/4.
 */
class ReduceActor(aggregateActor: ActorRef) extends Actor {
  override def receive: Receive = {
    case MapData(data) =>
      val list = data.groupBy(_.word).map {
        case (word, list) => WordCount(word, list.foldLeft(0)((count, wc) => count + wc.count))
      }.toList
      aggregateActor ! ReduceData(list)
    case msg => unhandled(msg)
  }
}
