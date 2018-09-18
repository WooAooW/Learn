package main

import (
	"fmt"
	"io"
	"os"
	"strings"
)

type myError float64

func (err myError) Error() string {
	return fmt.Sprint("thie is error number", err)
}

func testError(x float64) (float64, error) {
	if x < 0 {
		return x, myError(x)
	} else {
		return x, nil
	}
}

type rot13Reader struct {
	r io.Reader
}

func transform(b []byte) {
	fmt.Println("byte legth:", len(b))

	for i := 0; i < len(b); i++ {
		char := b[i]

		switch {
		case char >= 'A' && char <= 'M':
			char = char + 13
		case char >= 'a' && char <= 'm':
			char = char + 13
		case char >= 'N' && char <= 'Z':
			char = char - 13
		case char >= 'n' && char <= 'z':
			char = char - 13
		}

		b[i] = char
	}
}

func (reader *rot13Reader) Read(b []byte) (int, error) {
	n, err := reader.r.Read(b)

	transform(b)

	return n, err
}

func testRot() {
	s := strings.NewReader("Lbh penpxrq gur pbqr!")
	r := rot13Reader{s}
	io.Copy(os.Stdout, &r)
}

func main() {
	fmt.Println("Hello Word, Go Go Go ~~~")
	// testFor()
	// testIf()
	// testSwitch()
	// testDefer()
	// testPoint()
	// testArray()
	// testSlices()
	// testStrings()
	// testError(-1)
	// testError(1)
	testRot()
}
