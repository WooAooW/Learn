;call word ptr 地址, 修改 ip, 相当于 push ip, jmp word ptr 地址

;call dword ptr 地址, 修改 cs 和 ip, 相当于 push cs, push ip, jmp dword ptr 地址

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