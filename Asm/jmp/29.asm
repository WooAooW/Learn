;jmp指令执行后，CS:IP 指向程序的第一条指令

assume cs:code

data segment
	dd 12345678H
data ends

code segment

	main:
		mov ax, data
		mov ds, ax
		mov bx, 0
		mov [bx], bx
		mov [bx + 2], cs
		jmp dword ptr ds:[0]
		
code ends

end main