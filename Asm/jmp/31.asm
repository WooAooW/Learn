;一个奇怪的程序

assume cs:code

code segment

	mov ax, 4c00h
	int 21h

	main:
		mov ax, 0
	
	s:              ;复制后会变成 EBF6, 向前跳转 mov ax, 0 、 int 21h 、 mov ax, 4c00h -> jmp 0000
		nop
		nop

		mov di, offset s
		mov si, offset s2
		mov ax, cs:[si]
		mov cs:[di], ax

	s0:
		jmp short s

	s1:
		mov ax, 0
		int 21h
		mov ax, 0

	s2:
		jmp short s1 ;EBF6, 向前跳转 mov ax, 0 、 int 21h 、 mov ax, 0
		nop

code ends

end main