;把内存单元 ffff:0 ~ ffff:b 的内容 复制到 20:0 ~ 20:b

assume cs:code

code segment

	mov ax, 0ffffh
	mov ds, ax
	
	mov ax, 20h
	mov es, ax

	mov bx, 0

	mov cx, 0ch
	s:
		mov al, ds:[bx]
		mov es:[bx], al
		inc bx
		loop s

	mov ax, 4c00h
	int 21h

code ends

end