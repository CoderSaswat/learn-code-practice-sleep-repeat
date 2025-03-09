package main

import (
	"fmt"
	"strings"
)

func main() {
	arr1 := []int{1, 2, 3, 4, 5}
	arr2 := []int{1, 2, 3, 4, 5}

	//arr2 := []int{5, 1, 2, 3, 4}
	fmt.Println(isRotation(arr1, arr2))
	findMissingNoFromArithmaticProgression()
	moveAllZerosToEnd()
	checkInputContainsAllEnglishAlphabet()
	findDuplicateCharactersInString()
	reverserArr()
	duplicateElementsInarr()
	maxElementIArr()
	reverserArr()
	removeDuplicated()
	checkPalindrome()
	reverseStr()
}

func reverseStr() {
	//str := "saswat"

	//for i, j := 0, len(str)-1; i < j; i, j = i+1, j-1 {
	//	string(str[i]) = str[i] + str[j]
	//
	//}
}

func checkPalim(str string) bool {
	for i, j := 0, len(str)-1; i < j; i, j = i+1, j-1 {
		if (str[i]) != str[j] {
			return false
		}
	}
	return true
}

func checkPalindrome() {
	str := "moon"
	fmt.Println("is Palim")
	fmt.Println(checkPalim(str))
}

func removeDuplicated() {
	arr := []int{4, 77, 88, 33, 4, 64, 84, 33}
	removedDuplicateArr := make([]int, 0)
	lookUpMap := make(map[int]bool)
	for _, val := range arr {
		_, ok := lookUpMap[val]
		if !ok {
			removedDuplicateArr = append(removedDuplicateArr, val)
			lookUpMap[val] = true
		}
	}
	fmt.Println(removedDuplicateArr)
}

func maxElementIArr() {

}

func duplicateElementsInarr() {
	arr := []int{1, 2, 3, 2, 3, 6, 8, 6, 6}
	lookUpMap := make(map[int]bool)
	for _, val := range arr {
		_, ok := lookUpMap[val]
		if ok {
			fmt.Println(val)
			continue
		}
		lookUpMap[val] = true
	}
	//fmt.Println(lookUpMap)
}

func reverserArr() {
	arr := []int{1, 2, 3, 4, 5}
	for i, j := 0, len(arr)-1; i < j; i, j = i+1, j-1 {
		//a := arr[i]
		//arr[i] = arr[j]
		//arr[j] = a

		arr[i] = arr[i] + arr[j]
		arr[j] = arr[i] - arr[j]
		arr[i] = arr[i] - arr[j]
	}
	fmt.Println(arr)
}

func findDuplicateCharactersInString() {
	str := "saswat"
	var duplicates string
	check := make(map[string]bool)
	for i := 0; i < len(str); i++ {
		_, ok := check[string(str[i])]
		if ok {
			duplicates = duplicates + string(str[i])
			continue
		}
		check[string(str[i])] = true
	}
	fmt.Println(duplicates)
}

func checkInputContainsAllEnglishAlphabet() {
	str := "sasWWWWjjwEt"
	lower := strings.ToLower(str)
	fmt.Println(check1(lower))
}
func check1(str string) bool {
	for i := 0; i < len(str); i++ {
		if !(str[i] >= 'a' && str[i] <= 'z') {
			return false
		}
	}
	return true
}

func moveAllZerosToEnd() {
	arr := []int{1, 4, 2, 0, 0, 5, 0, 7, 0}
	noOfZero := 0
	arrModified := make([]int, 0)
	for _, val := range arr {
		if val == 0 {
			noOfZero++
			continue
		}
		arrModified = append(arrModified, val)
	}
	for noOfZero != 0 {
		arrModified = append(arrModified, 0)
		noOfZero--
	}
	fmt.Println(arrModified)
}

func findMissingNoFromArithmaticProgression() {
	//arr := []int{2, 4, 8, 10}
	//arr := []int{2, 6, 8, 10}
	arr := []int{1, 11, 21, 31}
	//arr := []int{2, 4, 8, 10}
	//arr := []int{2, 4, 8, 10}
	//2,6,8,10
	//8/4 = 2
	//if len(arr) == 0 || len(arr) == 1 || len(arr) == 2 {
	//	fmt.Println(-1)
	//}
	//12 / 4 = 3
	//1,4,7,13,16,19
	//18/6 = 3
	//1,11,21,41
	//40/4 = 10
	//30/4 = 7

	//var diff int
	//checkMap := make(map[int]bool)
	//for i := 0; i < len(arr); i++ {
	//	for j := 1; j < len(arr); j++ {
	//		diff = arr[j] - arr[i]
	//		_, ok := checkMap[diff]
	//		if ok {
	//			break
	//		}
	//		checkMap[diff] = true
	//	}
	//}

	diff := (arr[len(arr)-1] - arr[0]) / len(arr)
	for i, _ := range arr {
		if arr[i]+diff != arr[i+1] {
			fmt.Println(arr[i] + diff)
			break
		}
	}
}

func isRotation(arr1, arr2 []int) bool {
	if len(arr1) != len(arr2) {
		return false
	}
	if isSameArrays(arr1, arr2) {
		return false
	}
	combinedEx := append(arr1, arr1...)
	combinedExStr := fmt.Sprint(combinedEx)
	combinedExStr = strings.ReplaceAll(combinedExStr, "[", "")
	combinedExStr = strings.ReplaceAll(combinedExStr, "]", "")
	arr2Str := fmt.Sprint(arr2)
	arr2Str = strings.ReplaceAll(arr2Str, "[", "")
	arr2Str = strings.ReplaceAll(arr2Str, "]", "")
	if strings.Contains(combinedExStr, arr2Str) {
		return true
	}
	return false
}

func isSameArrays(arr1 []int, arr2 []int) bool {
	for i, val1 := range arr1 {
		if arr2[i] != val1 {
			return false
		}
	}
	return true
}
