drop Procedure [dbo].[sp_hienVatTu]
go

SET QUOTED_IDENTIFIER ON
go
SET ANSI_NULLS ON
go
create proc [dbo].[sp_hienVatTu]
as
begin
select * from VATTU
end
go
