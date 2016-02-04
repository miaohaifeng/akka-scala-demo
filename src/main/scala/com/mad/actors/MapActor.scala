package com.mad.actors

import java.util.StringTokenizer

import akka.actor.{Actor, ActorRef}
import com.mad.messages.{MapData, WordCount}
import scala.collection.mutable.ArrayBuffer

/**
 * Created by miaohaifeng
 * on 2016/2/4.
 */
class MapActor(reduceActor: ActorRef) extends Actor {
  override def receive: Receive = {
    case msg: String =>
      val mapData = getMapData(msg)
      reduceActor ! mapData
    case msg => unhandled(msg)
  }

  private def getMapData(msg: String): MapData = {

    val list = ArrayBuffer[WordCount]()
    val tokenizer: StringTokenizer = new StringTokenizer(msg)
    while (tokenizer.hasMoreTokens) {
      val word: String = tokenizer.nextToken.toLowerCase
      list += WordCount(word, 1)
    }
    MapData(list.toList)
  }


}
