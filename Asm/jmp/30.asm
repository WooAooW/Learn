;jcxz指令, 如果cx = 0, 就跳转

assume cs:code

code segment

	main:
		mov ax, 2000H
		mov ds, ax
		mov bx, 0
	s:
		mov cl, ds:[bx]
		mov ch, 0
		jcxz ok
		inc bx
		jmp short s
	ok:
		mov dx, bx
		mov ax, 4c00h
		int 21h
code ends

end main