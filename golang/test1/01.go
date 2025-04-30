package test1

import "fmt"

func main() {
	name := "Saswat Kumar Panda"
	runes := []rune(name)

	for i, j := 0, len(runes)-1; i < j; i, j = i+1, i-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	fmt.Println(string(runes))
}
