;jmp dword 指令

assume cs:code

code segment

	main:
		mov ax, 0123H
		mov [bx], ax
		mov word ptr [bx + 2], 0
		jmp dword ptr [bx]
		
code ends

end main