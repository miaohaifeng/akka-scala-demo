package com.mad.messages

/**
 * Created by miaohaifeng
 * on 2016/2/4.
 */
case class Result()

case class WordCount(word: String, count: Int)

case class MapData(data: List[WordCount])

case class ReduceData(data: List[WordCount])