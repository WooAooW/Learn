;ret  修改 ip 相当于 pop IP
;retf 修改 cs和ip 相当于 pop IP, pop CS

assume cs:code

stack segment
	db 16 dup (0)
stack ends

code segment

	mov ax, 4c00h
	int 21h

	main:
		mov ax, stack
		mov ss, ax
		mov sp, 16
		mov ax, 0
		push cs
		push ax
		mov bx, 0
		retf
code ends

end main