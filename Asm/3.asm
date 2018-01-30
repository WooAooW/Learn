;计算 内存单元 ffff:0006h 的值 * 3


assume cs:code

code segment

	mov ax, 0ffffh
	mov bx, 0006h

	mov ds, ax
	mov ax, [bx]
	mov ah, 0
	mov dx, 0

	mov cx, 3
	s: add dx, ax
	loop s

	mov ax, 4c00h
	int 21h

code ends

end