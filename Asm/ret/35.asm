;call 16位寄存器, 修改 ip, 相当于 push ip, jmp 16 位寄存器

assume cs:code

code segment

	main:
		mov ax, 6
		call ax
		inc ax
		mov bp, sp
		add ax, [bp]
code ends

end main