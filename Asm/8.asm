;向内存单元 20:00 ~ 20:3F 中 存入 0 ~ 63 0 ~ 3Fh

assume cs:code

code segment
	mov ax, 20h
	mov ds, ax

	mov bx, 0
	mov cx, 40h
	s: 
		mov ds:[bx], bl
		inc bl
		loop s

	mov ax, 4c00h
	int 21h

code ends

end