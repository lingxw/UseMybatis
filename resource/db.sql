USE [Jdt]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[jtdProject]') AND type in (N'U'))
DROP TABLE [dbo].[jtdProject]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[jtdPackage]') AND type in (N'U'))
DROP TABLE [dbo].[jtdPackage]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[jtdLibrary]') AND type in (N'U'))
DROP TABLE [dbo].[jtdLibrary]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[jtdSource]') AND type in (N'U'))
DROP TABLE [dbo].[jtdSource]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[jtdBinding]') AND type in (N'U'))
DROP TABLE [dbo].[jtdBinding]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[jtdProject](
	[id] [int] primary key identity,
	[path] [nchar](256) NULL,
	[name] [nchar](64) NULL
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[jtdPackage](
	[id] [int] primary key identity,
	[path] [nchar](256) NULL,
	[name] [nchar](64) NULL,
	[projId] [int] NULL
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[jtdLibrary](
	[id] [int] primary key identity,
	[path] [nchar](256) NULL,
	[name] [nchar](64) NULL,
	[projId] [int] NULL
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[jtdSource](
	[id] [int] primary key identity,
	[path] [nchar](256) NULL,
	[name] [nchar](64) NULL,
	[encoding] [nchar](16) NULL,
	[projId] [int] NULL
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[jtdBinding](
	[id] [int] primary key identity,
	[path] [nchar](256) NULL,
	[name] [nchar](64) NULL,
	[key] [nchar](256) NULL,
	[srcId] [int] NULL
) ON [PRIMARY]
GO
