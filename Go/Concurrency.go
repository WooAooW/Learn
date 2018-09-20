package main

import (
    "fmt"
    "time"
)

func say(s string) {
    for i := 0; i < 5; i++ {
        time.Sleep(100 * time.Millisecond)
        fmt.Println(s)
    }
}

func testGo() {
    go say("world")
    say("hello")
}

func fibonacci(n int, c chan int) {
    x, y := 0, 1
    for i := 0; i < n; i++ {
        c <- x
        x, y = y, x+y
    }
    close(c)
}

func testChan() {
    c := make(chan int)
    go fibonacci(10, c)
    for v := range c {
        fmt.Println(v)
    }
}

func testSelect() {
    tick := time.Tick(1000 * time.Millisecond)
    boom := time.After(5000 * time.Millisecond)

    for {
        select {
        case <-tick:
            fmt.Println("tick")
        case <-boom:
            fmt.Println("BOOM!")
            return
        default:
            fmt.Println("sleep")
            time.Sleep(500 * time.Millisecond)
        }
    }
}

func main() {
    // testGo()
    // testChan()
    testSelect()
}
