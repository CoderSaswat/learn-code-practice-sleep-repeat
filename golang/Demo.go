package main

//
//import (
//	"fmt"
//	"sync"
//)
//
//func main() {
//	//fmt.Println("Hello World")
//	//ch1 := make(chan int)
//	//ch2 := make(chan int)
//	//wg := new(sync.WaitGroup)
//	//wg.Add(1)
//	//go generateNumber(ch1, wg)
//	//wg.Add(1)
//	//go receiveNumbers(ch1, ch2, wg)
//	//go printNo(ch2, wg)
//	//wg.Wait()
//
//	//name := "saswat"
//	//idx := 3
//	//newStr := 'p'
//	//for i := 0; i < len(name); i++ {
//	//	if idx == 3 {
//	//		(name[i]) = newStr
//	//	}
//	//}
//
//	//arr := []int{2, 2, 1, 1, 1, 2, 2}
//	//
//	////3 - 2
//	////2 - 1
//	//minOccurence := len(arr) / 2
//	//lookUpMap := make(map[int]int)
//	//for _, val := range arr {
//	//	lookUpMap[val] = lookUpMap[val] + 1
//	//}
//	//for k, v := range lookUpMap {
//	//	if v > minOccurence {
//	//		fmt.Println(k)
//	//	}
//	//}
//	//fmt.Println(lookUpMap)
//
//	//
//	fmt.Println(findMajoringELements())
//	replaceString()
//	query()
//}
//
//func query() {
//	//emp, dept
//	//select e.e_name d.d_name
//	//join dept d
//	//on e.did = d.id
//
//}
//
//func replaceString() {
//	str := "saswat"
//	idx := 3
//	var newChar = 'j'
//	strUpdated := []rune(str)
//	strUpdated[idx] = newChar
//	fmt.Println(string(strUpdated))
//
//}
//
//func findMajoringELements() int {
//	nums := []int{1, 2, 5, 3, 3, 3, 3}
//	major := nums[0]
//	count := 1
//
//	for i := 1; i < len(nums); i++ {
//		if major == nums[i] {
//			count++
//		} else if count > 0 {
//			count--
//		} else {
//			major = nums[i]
//			count++
//		}
//	}
//
//	return major
//}
//
//func generateNumber(ch chan int, wg *sync.WaitGroup) {
//	defer wg.Done()
//	for i := 1; i <= 10; i++ {
//		ch <- i
//	}
//	close(ch)
//}
//func receiveNumbers(ch1, ch2 chan int, wg *sync.WaitGroup) {
//	//for {
//	//	select {
//	//	case val := <-ch1:
//	//		val = val * val
//	//		ch2 <- val
//	//	}
//	//}
//	defer wg.Done()
//	for val := range ch1 {
//		val = val * val
//		ch2 <- val
//	}
//
//}
//func printNo(ch1 chan int, wg *sync.WaitGroup) {
//	//for {
//	//	select {
//	//	case val := <-ch1:
//	//		fmt.Println(val)
//	//	}
//	//}
//	defer wg.Done()
//	for val := range ch1 {
//		fmt.Println(val)
//	}
//}
