package main

import (
	"fmt"
	"sync"
)

func main() {
	ch1 := make(chan int)
	ch2 := make(chan int)
	wg := sync.WaitGroup{}
	wg.Add(3)
	go generateNos(ch1, &wg)
	go squareNo(ch1, ch2, &wg)
	go printNos(ch2, &wg)
	wg.Wait()

	//time.Sleep(5 * time.Second)
}

func printNos(ch2 <-chan int, wg *sync.WaitGroup) {
	defer wg.Done()
	for val := range ch2 {
		fmt.Println(val)
	}
}

func squareNo(ch1 <-chan int, ch2 chan<- int, wg *sync.WaitGroup) {
	defer wg.Done()
	for val := range ch1 {
		val = val * val
		ch2 <- val
	}
	close(ch2)
}

func generateNos(ch1 chan<- int, wg *sync.WaitGroup) {
	//
	//name := "saswat"
	//r := []rune(name)
	//r[1] = 'k'
	//s := string(r)
	//fmt.Println(s)

	defer wg.Done()
	for i := 1; i <= 10; i++ {
		ch1 <- i
	}
	close(ch1)
}
