package main

import (
	"fmt"
	"math"
)

func main() {
	name := "Saswat Kumar Panda"
	runes := []rune(name)

	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	fmt.Println(string(runes))
	fmt.Println(isPalindrom("raceca"))

	arr := []int{45, 67, 45, 12}
	maxVal := arr[0]
	for _, val := range arr {
		if val > maxVal {
			maxVal = val
		}
	}

	maxV := math.MinInt
	secondMaxV := math.MinInt
	for _, val := range arr {
		if val > maxV {
			secondMaxV = maxVal
			maxV = val
		} else if val > secondMaxV {
			secondMaxV = val
		}
	}
	fmt.Println(secondMaxV)
}

func isPalindrom(str string) bool {
	runes := []rune(str)
	for i, j := 0, len(str)-1; i < j; i, j = i+1, j-1 {
		if runes[i] != runes[j] {
			return false
		}
	}
	return true
}
