## Learn Golang
```go
package main

import (
	"fmt"
	"time"
)

func main() {
	printAsciiArt()
	printCurrentTime()
}

func printAsciiArt() {
	fmt.Println("    `.-::::::-.`    ")
	fmt.Println(".:-::::::::::::::-:.")
	fmt.Println("`_:::    ::    :::_`")
	fmt.Println(" .:( ^   :: ^   ):. ")
	fmt.Println(" `:::   (..)   :::. ")
	fmt.Println(" `:::::::UU:::::::` ")
	fmt.Println(" .::::::::::::::::. ")
	fmt.Println(" O::::::::::::::::O ")
	fmt.Println(" -::::::::::::::::- ")
	fmt.Println(" `::::::::::::::::` ")
	fmt.Println("  .::::::::::::::.  ")
	fmt.Println("     oO:::::::Oo    ")
}

func printCurrentTime() {
	currentTime := time.Now()
	fmt.Println("ASCII art printed at:", currentTime.Format("Mon Jan 2 15:04:05 MST 2006"))
}
```
