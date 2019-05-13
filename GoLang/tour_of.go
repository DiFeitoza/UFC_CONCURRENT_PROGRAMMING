package main

import (
	"fmt"
	"math"
	"math/cmplx"
	"math/rand"
	"time"
)

func main() {
	//1
	fmt.Println("Welcome to the playground!")
	fmt.Println("The time is", time.Now())
	fmt.Println("My favorite number is", rand.Intn(100)) //fmt.Println("My favorite number is", rand.Seed())
	fmt.Printf("Now you have %g problems.\n", math.Sqrt(7))

	//2
	fmt.Println(math.Pi) //erro na nomenclatura pi->Pi fmt.Println(math.pi)

	//3
	fmt.Println(add(2, 3))

	//4
	a, b := swap("hello", "world")
	fmt.Println(a, b)

	//5
	fmt.Println(split(10))

	//6
	var i int
	var c, python, java bool
	fmt.Println(i, c, python, java)

	//7 - If an initializer is present, the type can be omitted
	var j, k int = 1, 2
	var d, e, f = true, false, "no!"
	fmt.Println(j, k, d, e, f)

	//8 - declaracao curta := só dentro de func
	l := 3
	cpp, py, jav := true, false, "no!"
	fmt.Println(l, cpp, py, jav)

	//9
	/*
		bool
		string
		int  int8  int16  int32  int64
		uint uint8 uint16 uint32 uint64 uintptr
		byte (alias for uint8)
		rune (alias for int32; represents a Unicode code point
		float32 float64
		complex64 complex128
	*/
	var (
		ToBe          = false
		MaxInt uint64 = 1<<64 - 1
		z             = cmplx.Sqrt(-5 + 12i) //complex128
	)

	fmt.Printf("Type: %T Value: %v\n", ToBe, ToBe)
	fmt.Printf("Type: %T Value: %v\n", MaxInt, MaxInt)
	fmt.Printf("Type: %T Value: %v\n", z, z)

	//10 - Variables declared without an explicit initial value are given their zero value.
	var in int
	var fl float64
	var bo bool
	var st string
	fmt.Printf("%v %v %v %q\n", in, fl, bo, st)

}

//3 - declarando uma func
func add(x, y int) int {
	return x + y
}

//4 - retornando dois valores
func swap(a, b string) (string, string) {
	return b, a
}

//5 - naked return (retorno nu); retorno nomeado como x e y, logo presupoe o retorno
func split(sum int) (x, y int) {
	x = sum * 4 / 5
	y = sum - x
	return
}
