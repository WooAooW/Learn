;计算 ffff:0 ~ ffff:b 中数据的和，并存储到dx中

assume cs:code

code segment

	mov ax, 0ffffh
	mov ds, ax

	mov bx, 0
	mov cx, 0bh
	mov dx, 0

	s:
		mov ax, [bx]
		mov ah, 0
		add dx, ax
		inc bx       ;相当于 add bx, 1
		loop s

	mov ax, 4c00h
	int 21h

code ends

end