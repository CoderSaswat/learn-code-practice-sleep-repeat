package main

import (
	"fmt"
	"log/slog"
	"sort"
	"time"
)

type person struct {
	name string
	id   int
}

type StudentService interface {
	addStudent()
}

type Square struct {
	a int
}
type Rectangle struct {
	a, b int
}
type Area interface {
	area()
}

func main() {
	fmt.Println("hi")
	students := []string{"virat", "hohli"}
	for _, student := range students {
		fmt.Println(student)
	}
	//var studentsList []string
	//var age  = 10
	//age := 10.0
	var ageList []int
	//ageList[0] = 10
	//ageList[1] = 20

	for _, age := range ageList {
		fmt.Println(age)
	}

	personMap := make(map[string]person)
	personMap["1"] = person{
		name: "Saswat",
		id:   10,
	}
	var person2 []person
	var person3 []map[string]person
	var person4 []map[string][]person
	var person5 map[string][]map[string]person

	person2 = []person{
		{
			name: "",
			id:   0,
		},
		{
			name: "",
			id:   0,
		},
	}
	person3 = []map[string]person{
		{
			"1": person{
				name: "",
				id:   0,
			},
		},
		{"2": person{
			name: "",
			id:   0,
		}},
	}
	person4 = []map[string][]person{
		{"1": []person{
			{
				name: "Saswat",
				id:   1,
			},
			{
				name: "Viart",
				id:   2,
			},
		}},
		{"2": []person{{
			name: "Rohit",
			id:   3,
		}, {
			name: "Kohli",
			id:   4,
		}}},
	}
	person5 = map[string][]map[string]person{
		"1stClassStudents": {{
			"saswat": {
				name: "saswat",
				id:   1,
			},
		}, {
			"kohli": {
				name: "kohli",
				id:   2,
			},
		}},
		"2ndClassStudents": {{
			"rohit": {
				name: "rohtt",
				id:   3,
			},
		}, {"rahul": {
			name: "rahul",
			id:   4,
		}}},
	}
	fmt.Println(len(person2))
	fmt.Println(len(person3))
	fmt.Println(len(person4))
	fmt.Println(len(person5))
	fmt.Println(len(person2))

	var shapeObject Area
	rec := Rectangle{
		a: 10,
		b: 20,
	}
	shapeObject = rec
	shapeObject.area()

	_, exists := person5["1stClassStudents"]
	fmt.Println(exists)

	i1 := 1
	i2 := 2.9
	fmt.Println(float64(i1) + i2)

	//for i := 0; i < ; i++ {
	//
	//}
	//
	//for i, i3 := range collection {
	//
	//}
	//for exists {
	//
	//}

	var arr []any = []any{1, 2, 4, 3.5, "hh"}
	val, ok := arr[4].(string)
	if ok {
		fmt.Println(val)
	}

	ch1 := make(chan string)
	go callF1(ch1)
	fmt.Println(<-ch1)
	fmt.Println(<-ch1)

	ch2 := make(chan string, 5)
	go callF2(ch2)
	fmt.Println(<-ch2)
	fmt.Println(<-ch2)

	ch3 := make(chan int) // Unbuffered channel
	go callF3(ch3)
	fmt.Println("Waiting to receive value...")
	value := <-ch3  // Blocks until the goroutine sends
	value2 := <-ch3 // Blocks until the goroutine sends
	fmt.Println("Received value:", value, value2)

	personList1 := []person{
		{
			name: "viratb",
			id:   2,
		}, {
			name: "virata",
			id:   2,
		}, {
			name: "saswat",
			id:   1,
		}}
	//sort.Slice(personList1, func(i, j int) bool {
	//	return personList1[i].id < personList1[j].id
	//})

	//multi level sort
	sort.Slice(personList1, func(i, j int) bool {
		if personList1[i].id == personList1[j].id {
			return personList1[i].name < personList1[j].name
		}
		return personList1[i].id < personList1[j].id
	})
	fmt.Println(personList1)
	var num1 interface{} = 10.3
	switch num1.(type) {
	case string:
		fmt.Println("string")
	case float64:
		fmt.Println("float64")
	}
	a := struct{}{}
	fmt.Println(a)

	checkGreater(1, 300, 45)

	const PI float64 = 3.141
	//PI = 8.0
	fmt.Println(PI)
	stopChnl := make(chan bool)
	go startWork(stopChnl)
	time.Sleep(3 * time.Second)
	close(stopChnl)

}

func startWork(chnl chan bool) {
	for {
		select {
		case <-chnl:
			fmt.Println("stoping the chnl")
			return
		default:
			fmt.Println("working...")
			time.Sleep(1 * time.Second)
		}
	}
}

func callF3(ch3 chan int) {
	fmt.Println("Sending value 42...")
	ch3 <- 42 // Blocks until main goroutine receives
	ch3 <- 43 // Blocks until main goroutine receives
	fmt.Println("Value sent!")
}

func callF2(ch2 chan string) {
	ch2 <- "one"
	ch2 <- "two"
}

func callF1(ch1 chan string) {
	ch1 <- "from chan1"
	ch1 <- "from chan1 test"
	close(ch1)
}

func (p person) addStudent() {
	slog.Info("adding student")
}
func (s Square) area() {
	slog.Info("area of square")
}
func (r Rectangle) area() {
	slog.Info("area of rectangle")
}

func checkGreater(vals ...int) {
	max := vals[0]
	for _, val := range vals {
		if val > max {
			max = val
		}
	}
	fmt.Println("greater :", max)
}
