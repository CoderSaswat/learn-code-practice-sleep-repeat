package main

import "fmt"

type Orange struct {
	Quantity int
}

func (o *Orange) Increase(n int) {
	o.Quantity += n
}

func (o *Orange) Decrease(n int) {
	o.Quantity -= n
}

func (o *Orange) String() string {
	return fmt.Sprintf("%v", o.Quantity)
}

func main() {
	//arr := []int{1, 2, 3}
	//arrCopy := arr
	//arrCopy[0] = 99
	//fmt.Println("Original:", arr)     //99,2,3
	//fmt.Println("Copy    :", arrCopy) //99,2,3

	//Given an array of integers nums and an integer target, return
	//indices of the two numbers such that they add up to target
	//Input: nums = [2, 7, 11, 15], target = 9
	//	Output: [0, 1]

	nums := []int{2, 7, 11, 15}
	target := 9
	//brute force -
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			if nums[i]+nums[j] == target {
				//return i ,j
				break
			}
		}
	}
	//time - o(N)
	// nums = [2, 7, 11, 15,17,19], target = 9
	//map of  value and index

	//map : 2 ->0

	//9-7 = 2;

	//[1,0]

	//time-o(logn)

	a := 11
	b := 21

	temp := a
	a = b
	b = temp

	a, b = b, a
}
