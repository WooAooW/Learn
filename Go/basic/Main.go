package main

import (
	"fmt"
	"strings"
)

func testDefer() {
	fmt.Println("defer print")
	for i := 1; i < 10; i++ {
		defer fmt.Println(i)
	}
	fmt.Println("defer finish")
}

func testPoint() {
	i := 123
	var p = &i

	fmt.Println("i -> ", i)
	fmt.Println("p -> ", p, *p)
}

func testArray() {
	var strs [2]string
	strs[0] = "first"
	strs[1] = "go go go"

	fmt.Println(strs)

	numbers := [10]int{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}
	s := numbers[5:7]
	fmt.Println(s)
}

func testSlices() {
	// https://tour.go-zh.org/moretypes/18
	var dx = 10
	var dy = 5

	slice := make([][]uint8, dy)

	for index := range slice {
		slice[index] = make([]uint8, dx)
	}

	for y := range slice {
		for x := range slice[y] {
			slice[y][x] = uint8((x + y) / 2)
		}
	}
}

func testStrings() {
	s := " foo bar  baz   "

	wordMap := make(map[string]int)

	fields := strings.Fields(s)
	for _, word := range fields {
		wordMap[word] = wordMap[word] + 1
	}

	fmt.Println(wordMap)
}

func main() {
	fmt.Println("Hello Word, Go Go Go ~~~")
	// testFor()
	// testIf()
	// testSwitch()
	// testDefer()
	// testPoint()
	// testArray()
	// testSlices()
	// testStrings()
	// testRot()
}
