;把数据逆序存放

assume cs:code

code segment

	dw 0123h, 0456h, 0789h, 0abch, 0defh, 0cbah, 0987h, 0654h
	dw 0, 0, 0, 0, 0, 0, 0, 0
	dw 0, 0, 0, 0, 0, 0, 0, 0

	main:
		mov ax, cs
		mov ss, ax
		mov sp, 30h

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