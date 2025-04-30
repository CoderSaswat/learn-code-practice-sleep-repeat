package main

import (
	"fmt"
	"sync"
)

func main() {
	//i := 1
	//defer fmt.Println(i + 1) //1
	//i++                      //2
	//fmt.Println("hello")

	//number := make([]int, 0)
	//fmt.Println(number[0])
	//
	//var m map[int]int
	//val, exists:=m[1]
	//fmt.Println(m[1])

	//a := []int{1, 2, 3}
	//b := a[:1]
	//fmt.Println("Slice b:", b)
	//b = append(b, 4)
	//fmt.Println("Slice a:", a)
	//fmt.Println("Slice b:", b)

	//arr := []int{1, 2, 3, 5, 6, 7, 8, 9}
	//
	////sort
	//missingEle := 0
	////dupliateEle := 0
	//for i := 0; i < len(arr)-1; i++ {
	//	if arr[i]+1 != arr[i+1] {
	//		missingEle = arr[i]
	//	}
	//}
	//fmt.Println(missingEle + 1)

	wg := sync.WaitGroup{}
	ch1 := make(chan int)
	wg.Add(2)
	go produceNos(ch1, &wg)
	go receiveNos(ch1, &wg)
	wg.Wait()
}

func receiveNos(ch1 chan int, wg *sync.WaitGroup) {
	defer wg.Done()
	for data := range ch1 {
		fmt.Println(data)
	}
}

func produceNos(ch1 chan int, wg *sync.WaitGroup) {
	defer wg.Done()
	for i := 1; i <= 10; i++ {
		ch1 <- i
	}
	close(ch1)
}
