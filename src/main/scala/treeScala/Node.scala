package treeScala

import scala.collection.mutable
import scala.collection.mutable.Queue
import scala.util.control.Breaks._
import scala.collection.mutable.Stack

/**
  * Created by PSwain on 5/23/2017.
  */
class Node(var value:Int, var left:Node, var right:Node)

object Node {

  def addNode(rootNode: Node, node: Node): Unit = {
    var queue = new mutable.Queue[Node]()
    queue.enqueue(rootNode)
    breakable {
      while (!queue.isEmpty) {
        var currentNode = queue.dequeue()
        if (currentNode.left == null) {
          currentNode.left = node
          break
        } else queue.enqueue(currentNode.left)
        if (currentNode.right == null) {
          currentNode.right = node
          break
        } else queue.enqueue(currentNode.right)
      }
    }
  }
}

 /* def maxElement(rootNode:Node): Int ={

    var stack=new mutable.Stack[Node]()
    var currentNode=rootNode
    var maxElement=Int.MinValue
    while(true){

      breakable{

        while(currentNode != null){

          stack.push(currentNode)
          if(currentNode.value > maxElement){
            maxElement = currentNode.value
          }
          if(currentNode.left != null){
            stack.push(currentNode.left)
            currentNode=currentNode.left
          }else break
        }









      }

    }
  }*/


