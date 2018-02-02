;同一个程序中有多个段

assume cs:code

data segment
	dw 0123h, 0456h, 0789h, 0abch, 0defh, 0cbah, 0987h, 0654h
data ends

stack segment
	dw 0, 0, 0, 0, 0, 0, 0, 0
	dw 0, 0, 0, 0, 0, 0, 0, 0
stack ends

code segment

	main:
		mov ax, stack
		mov ss, ax
		mov sp, 20h

		mov ax, data
		mov ds, ax

		mov bx, 0
		mov cx, 8
		s1:
			push cs:[bx]
			add bx, 2
			loop s1

		mov bx, 0
		mov cx, 8
		s2:
			pop cs:[bx]
			add bx, 2
			loop s2

	mov ax, 4c00h
	int 21h

code ends

end main