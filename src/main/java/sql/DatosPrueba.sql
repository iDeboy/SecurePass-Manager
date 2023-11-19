INSERT INTO T_USUARIOS (PK_Nombre_Usuario, Password, Nombre_Usuario_Titular, AP_PAT, AP_MAT)
VALUES
	-- Password: pass123
	('usuario01', 'S28LiAzqBLXHIvwC+7FN+Q==', 'Juan Pérez', 'Pérez', 'González'),
  -- Password: securePWD456
	('user2023', '3dqvLA+gxbUk9qifYGwukw==', 'María García', 'García', 'López'),
  -- Password: qwerty789
	('johnDoe', '9o9p+Y4k0cpVMmnm6ZrJTQ==', 'John Doe', 'Doe', 'Smith'),
  -- Password: passJane123
	('janeSmith', 'EDJ+EMd452peYzvq+vbl4g==', 'Jane Smith', 'Smith', 'Johnson');

INSERT INTO T_CREDENCIALES (Nombre_Plataforma, Usuario_Web, URL, Password, Fecha_Alta, Fecha_Update, Extra, FK_Nombre_Usuario)
VALUES
  -- Password: GmailPass123
	('Gmail', 'juan.perez@gmail.com', 'www.gmail.com', 'DxUjcbmjVmInTsJoV0zYZQ==', '2023-01-15 08:00:00', '2023-11-19 15:30:00', 'Correo personal', 'usuario01'),
  -- Password: FBsecurePwd456
	('Facebook', 'maria.garcia', 'www.facebook.com', 'EbYB/39dJtyGcq+lFeLN+w==', '2023-03-20 10:45:00', '2023-11-18 12:20:00', 'Red social', 'user2023'),
	-- Password: LiNkEdin789!
	('LinkedIn', 'john_doe_linked', 'www.linkedin.com', 'Pnkb9Eft9lQSEiYGt9WbUQ==', '2023-05-10 16:20:00', '2023-11-15 09:10:00', 'Red profesional', 'johnDoe'),
  -- Password: TwitterPass123
	('Twitter', 'jane_smith', 'www.twitter.com', 'gFAPnj4SfUVSD6bmP48XYw==', '2023-07-25 14:00:00', '2023-11-19 17:45:00', 'Otra red social', 'janeSmith');

INSERT INTO T_CREDENCIALES_BANCARIAS (Nombre_Banco, Numero_Tarjeta, CVV, Fecha_Caducidad, Fecha_Alta, Fecha_Update, Extra, FK_Nombre_Usuario)
VALUES
	-- CVV: 123
	('Banco X', '1234567890123456', 'ubaPglcHc/ohbKr5b/yiLw==', '2025-06-30', '2023-02-28 11:30:00', '2023-11-19 09:00:00', 'Cuenta de ahorros', 'usuario01'),
	-- CVV: 456
	('Banco Y', '9876543210987654', 'vdzUejppObkV66ohDxlUMQ==', '2024-12-31', '2023-04-10 13:45:00', '2023-11-18 16:20:00', 'Tarjeta de crédito', 'user2023'),
  -- CVV: 789
	('Banco Z', '5678901234567890', 'BG9glNyMk9JI7pxZvap8yQ==', '2026-09-15', '2023-06-05 17:00:00', '2023-11-17 10:40:00', 'Cuenta corriente', 'johnDoe'),
	-- CVV: 321
	('Banco A', '7890123456789012', 'o2cxkqX/8JxeBvHmbWjgnw==', '2023-11-30', '2023-08-20 09:15:00', '2023-11-19 14:55:00', 'Tarjeta corporativa', 'janeSmith');