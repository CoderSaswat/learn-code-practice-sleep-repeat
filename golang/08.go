package main

import (
	"fmt"
)

func main() {

	//ch1 := make(chan string)
	//
	//go genNos(ch1)
	//go printValues(ch1)
	//time.Sleep(5 * time.Second)

	arr := []int{1, 3, 2, 5, 7, 4}

	for i, j := 0, len(arr)-1; i < j; {
		arr[i], arr[j] = arr[j], arr[i]
		i++
		j--
	}
	fmt.Println(arr)

}

func genNos(ch1 chan string) {
	myMap := make(map[int]string)
	myMap[1] = "saswat1"
	myMap[2] = "saswat2"
	myMap[3] = "saswat3"
	myMap[4] = "saswat4"
	fmt.Println(myMap)

	//
	for k, v := range myMap {
		fmt.Println(k, v)
		ch1 <- v
	}
	close(ch1)
}

func printValues(ch1 chan string) {
	for val := range ch1 {
		fmt.Println(val)
	}

}
