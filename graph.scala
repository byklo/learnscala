import scala.collection.mutable.Map

// class for a directed graph

case class Graph() {
	private val adjacency_list = Map[Int, Vector[Int]]()

	def edgeExists(v1: Int, v2: Int): Boolean = {
		adjacency_list.get(v1) match {
			case Some(x) => x.contains(v2)
			case None => false
		}
	}

	def nodeExists(v1: Int): Boolean = if (adjacency_list.get(v1) == None) false else true

	def addNode(v1: Int) { if (nodeExists(v1)) () else adjacency_list += (v1 -> Vector[Int]()) }

	def addEdge(v1: Int, v2: Int) {
		if (nodeExists(v1) && ! edgeExists(v1, v2))
			adjacency_list += (v1 -> (adjacency_list(v1) :+ v2))
	}

	def print() {
		adjacency_list.foreach{ case (key, list) => {
			System.out.print(s"${key} :")
			list.foreach{ x => System.out.print(s" ${x}") }
			println()
		}}
	}
}

object Graph {
	def main(args: Array[String]) {
		println("> graph.scala <")
		var graph = Graph()
		graph.addNode(5)
		graph.addNode(2)
		graph.addNode(7)
		graph.addNode(8)
		graph.addNode(1)
		graph.addNode(0)
		graph.print()
		graph.addEdge(5, 2)
		graph.addEdge(5, 7)
		graph.addEdge(7, 5)
		graph.addEdge(7, 1)
		graph.addEdge(1, 8)
		graph.addEdge(8, 2)
		graph.print()
	}
}
