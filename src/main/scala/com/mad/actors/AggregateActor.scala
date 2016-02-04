package com.mad.actors

import akka.actor.Actor
import com.mad.messages.{ReduceData, Result}
import scala.collection.mutable

/**
 * Created by miaohaifeng
 * on 2016/2/4.
 */
class AggregateActor extends Actor {
  val finalData = mutable.HashMap[String, Int]()

  override def receive: Receive = {
    case ReduceData(data) =>
      data.foreach(wc => {
        finalData.put(wc.word, finalData.getOrElse(wc.word, 0) + wc.count)
      })
    case Result() =>
      println(finalData)
    case msg => unhandled(msg)
  }
}
