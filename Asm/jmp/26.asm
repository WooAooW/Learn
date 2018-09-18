;jmp word 指令

assume cs:code

code segment

	main:
		mov ax, 0123H
		mov [bx], ax
		jmp word ptr [bx]

code ends

end main