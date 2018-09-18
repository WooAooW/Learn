;call 修改 ip, 相当于 push ip, jmp near ptr 位置

;call far ptr 位置, 修改 cs 和 ip, 相当于 push cs, push ip, jmp far ptr 位置

assume cs:code

code segment

	main:
		mov ax, 0
		call far ptr s
		inc ax
		s:
			pop ax
			add ax, ax
			pop bx
			add ax, bx
code ends

end main