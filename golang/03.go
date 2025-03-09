package main

import (
	"fmt"
	"sort"
)

var initializedValue string

func init() {
	//fmt.Println("Initializing...")
	//initializedValue = "Hello, World!"
}

type People struct {
	Name string
	Id   int
}

func main() {
	//var err error
	//err = errors.New("this is a error")
	//fmt.Println(err.Error())
	//
	//defer func() {
	//	if r := recover(); r != nil {
	//		fmt.Println("Recovered from panic:", r)
	//	}
	//}()
	//
	//fmt.Println("Before panic")
	////panic("Something went wrong!") // Triggers a panic
	//fmt.Println("After panic") // This line will not execute
	//const PI = 3.141
	//fmt.Println(PI)

	//channels

	//ch1 := make(chan int)
	//fmt.Println("before sending data to channel")
	//ch1 <- 11                                    //This will block because there is no receiver
	//fmt.Println("after sending data to channel") // This line will never be executed

	//arr1 := make([]int, 0)
	//arr1 = append(arr1, 1, 2, 3, 4, 5)
	//arr2 := []int{11, 22, 33}
	//var arr3 []int
	//arr3 = append(arr3, 55, 66, 77)
	//
	//fmt.Println(arr1)
	//fmt.Println(arr2)
	//fmt.Println(arr3)
	//
	//var arr4 = make([]int, 0)
	//arr4 = append(append(arr1, arr2...), arr3...)
	//fmt.Println(arr4)
	//
	//personMap := make(map[string]People)
	//personMap["saswat"] = People{
	//	Name: "saswat",
	//	Id:   1,
	//}
	//fmt.Println(personMap["saswat2"])
	//for k, v := range personMap {
	//	fmt.Println(k, v)
	//}

	//f1()
	//var myFn = func(a, b int) int {
	//	return a + b
	//}
	//fmt.Println(myFn(6, 4))
	//aa := [3]int{1, 2}
	//fmt.Println(aa[2])
	arr2 := []int{1, 54, 7, 8}
	sort.Slice(arr2, func(i, j int) bool {
		return arr2[i] > arr2[j]
	})
	arr3 := []People{{
		Name: "saswat",
		Id:   2,
	}, {
		Name: "papun",
		Id:   1,
	}}
	sort.Slice(arr3, func(i, j int) bool {
		return arr3[i].Id < arr3[j].Id
	})
	fmt.Println(arr3)
}

func f1() {
	defer fmt.Println("defer f1")
	fmt.Println("f1")
	f2()
}
func f2() {
	defer fmt.Println("defer f2")
	fmt.Println("f2")
	f3()
}
func f3() {
	defer fmt.Println("defer f3")
	fmt.Println("f3")
	panic("something went wrong")
}
