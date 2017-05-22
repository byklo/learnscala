import scala.collection.immutable.HashMap

def fib_rec(n: Int): Int = {
	if (n == 0 || n == 1)
		1
	else
		fib_rec(n - 1) + fib_rec(n - 2)
}

def fib_rec_case(n: Int): Int = {
	n match {
		case 0 | 1 => 1
		case _ => fib_rec_case(n - 1) + fib_rec_case(n - 2)
	}
}

def fib_it(n: Int): Int = {
	if (n == 0 || n == 1)
		1
	var a :Int = 1
	var b :Int = 1
	for (i <- 2 to n) {
		val temp = b
		b += a
		a = temp
	}
	b
}

def fib_memo(n: Int) = {
	def fib_rec_memo(n: Int, memo: HashMap[Int, Int]): Int = {
		n match {
			case 0 | 1 => 1
			case _ => {
				if (memo.contains(n))
					memo.get(n).get
				else
					fib_rec_memo(n - 1, memo) + fib_rec_memo(n - 2, memo)
			}
		}
	}

	val memo = HashMap[Int, Int]()
	fib_rec_memo(n, memo)
}

var i = 0;

while (i < 5) {
	print(s"fib(${i}) = ${fib_rec(i)}\n")
	i += 1
}

for (n <- 5 until 10)
	printf("fib(%s) = %s\n", n, fib_rec_case(n))

(10 to 14).foreach(x => println(s"fib(${x}) = ${fib_it(x)}"))

(15 to 20) map (x => println(s"fib(${x}) = ${fib_memo(x)}"))
