package com.mad

import akka.actor.{ActorSystem, Props}
import com.mad.actors.MasterActor
import com.mad.messages.Result

/**
 * Created by miaohaifeng
 * on 2016/2/4.
 */
object HelloAkka {
  def main(args: Array[String]) {
    val _system = ActorSystem("HelloAkka")
    val master = _system.actorOf(Props[MasterActor], "master")
    master ! "hello world hadoop"
    master ! "hello hadoop"
    master ! " hello spark world"
    Thread.sleep(1000)
    master ! Result()
    Thread.sleep(1000)
    _system.shutdown()
  }
}
