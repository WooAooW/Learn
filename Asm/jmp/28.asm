;jmp指令执行后，CS:IP 指向程序的第一条指令

assume cs:code

data segment
	dd 0H
data ends

code segment

	main:
		mov ax, data
		mov ds, ax
		mov bx, 0
		jmp word ptr [bx + 1]
		
code ends

end main