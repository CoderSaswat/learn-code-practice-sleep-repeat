package main

import (
	"context"
	"fmt"
	"time"
)

func main() {
	//ch1 := make(chan int)
	//fmt.Println("before sending data to channel")
	//ch1 <- 11                                    //This will block because there is no receiver
	//fmt.Println("after sending data to channel") // This line will never be executed

	//ch2 := make(chan int)
	//fmt.Println("before received")
	//val := <-ch2 //This will block because there is no sender
	//fmt.Println("after received")
	//fmt.Println(val) // This line will never be executed

	//ch1 := make(chan int)
	//go func() {
	//	ch1 <- 42
	//}()
	//val := <-ch1
	//fmt.Println(val)

	//ch2 := make(chan int)
	//go func() {
	//	val := <-ch2
	//	fmt.Println(val)
	//}()
	//ch2 <- 42

	//ch3 := make(chan string) // Unbuffered channel
	//
	//// Worker 1 (Sender)
	//go func() {
	//	fmt.Println("Worker 1: Assembling part")
	//	ch3 <- "Part A assembled" // Blocks until Worker 2 receives
	//	fmt.Println("Worker 1: Part passed to Worker 2")
	//}()
	//
	//// Worker 2 (Receiver)
	//go func() {
	//	msg := <-ch3 // Blocks until Worker 1 sends
	//	fmt.Println("Worker 2: Received:", msg)
	//}()

	// Wait for user input to keep the program alive
	//ch4 := make(chan bool)
	//go print(ch4)
	//time.Sleep(10 * time.Second)
	//ch4 <- true

	//ctx, cancelFn := context.WithCancel(context.Background())
	//go printWithCtx(ctx)
	//time.Sleep(10 * time.Second)
	//cancelFn()
	//
	//ch5 := make(chan int, 2)
	//go func() {
	//	ch5 <- 1
	//	fmt.Println("Sender: Sent 1")
	//	ch5 <- 2
	//	fmt.Println("Sender: Sent 2")
	//	ch5 <- 3 //blocking
	//	fmt.Println("Sender: Sent 3")
	//}()
	//go func() {
	//	time.Sleep(5 * time.Second)
	//	val1 := <-ch5
	//	fmt.Println(val1)
	//	val2 := <-ch5
	//	fmt.Println(val2)
	//	val3 := <-ch5
	//	fmt.Println(val3)
	//}()

	//ch6 := make(chan int)
	//go func() {
	//	for i := 1; i <= 10; i++ {
	//		ch6 <- i
	//	}
	//	close(ch6)
	//}()
	//
	//go func() {
	//	for val := range ch6 {
	//		fmt.Println(val)
	//	}
	//}()

	ch1 := make(chan string)
	ch2 := make(chan string)

	go func() {
		time.Sleep(15 * time.Second)
		ch1 <- "Message from ch1"
	}()

	go func() {
		time.Sleep(5 * time.Second)
		ch2 <- "Message from ch2"
	}()

	for i := 0; i < 2; i++ {
		fmt.Println("first")
		select {
		case msg1 := <-ch1:
			fmt.Println(msg1)
		case msg2 := <-ch2:
			fmt.Println(msg2)
		}
	}

	ch := make(chan bool)
	go printNumbers(ch)
	time.Sleep(5 * time.Second)
	ch <- true

	fmt.Scanln()
}

func print(stop chan bool) {
	for i := 1; true; i++ {
		select {
		case <-stop:
			fmt.Println("stopping")
			return
		default:
			fmt.Println(i)
			time.Sleep(time.Second)
		}
	}
}

func printWithCtx(ctx context.Context) {
	for i := 1; true; i++ {
		select {
		case <-ctx.Done():
			fmt.Println("stopping")
			return
		default:
			fmt.Println(i)
			time.Sleep(time.Second)
		}
	}
}
func printNumbers(ch chan bool) {
	for i := 1; ; i++ {
		select {
		case <-ch:
			fmt.Println("stopping the goroutine")
			return
		default:
			fmt.Println(i)
			time.Sleep(1 * time.Second)
		}
	}

}
