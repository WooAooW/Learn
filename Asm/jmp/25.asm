;jmp指令
;short 机器码不存储地址, 存储跳多少个字节 EB xx
;far   机器码会优化成 short, 256 范围内的
;far   机器码存储跳转的地址 EA dcba -> jmp ab:cd

assume cs:code

code segment

	main:
		mov ax, 0
		mov bx, 0
		jmp short s1     ;8位位移
		add ax, 1
		db 124 dup (0)
		;db 127 dup (0)  会报错, 超过范围
		s1:
			inc ax

		jmp near ptr s2  ;16位位移, 段内
		add ax, 1
		db 256 dup (0)
		s2:
			inc ax

		jmp far ptr s3   ;段间跳转
		add bx, 1
		db 256 dup (0)
		s3:
			inc ax
		
code ends

end main