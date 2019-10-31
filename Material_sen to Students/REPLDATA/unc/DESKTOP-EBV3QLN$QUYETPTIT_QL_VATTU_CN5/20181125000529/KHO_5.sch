drop Table [dbo].[KHO]
go
SET ANSI_PADDING ON
go

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHO](
	[MAKHO] [char](6) NOT NULL,
	[TENKHO] [nvarchar](100) NOT NULL,
	[DIACHI] [nvarchar](100) NOT NULL,
	[MACN] [char](4) NOT NULL,
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL
)

GO
ALTER TABLE [dbo].[KHO] ADD  CONSTRAINT [MSmerge_df_rowguid_99B7AA2670E6429EA292876C280D68BD]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
SET ANSI_NULLS ON

go

SET QUOTED_IDENTIFIER ON

go

SET ANSI_PADDING ON

GO
ALTER TABLE [dbo].[KHO] ADD  CONSTRAINT [PK_KHO] PRIMARY KEY CLUSTERED 
(
	[MAKHO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
GO
