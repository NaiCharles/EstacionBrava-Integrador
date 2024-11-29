[1mdiff --git a/.classpath b/.classpath[m
[1mdeleted file mode 100644[m
[1mindex 63c3267..0000000[m
[1m--- a/.classpath[m
[1m+++ /dev/null[m
[36m@@ -1,15 +0,0 @@[m
[31m-<?xml version="1.0" encoding="UTF-8"?>[m
[31m-<classpath>[m
[31m-	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-22">[m
[31m-		<attributes>[m
[31m-			<attribute name="module" value="true"/>[m
[31m-		</attributes>[m
[31m-	</classpathentry>[m
[31m-	<classpathentry kind="src" path="src"/>[m
[31m-	<classpathentry kind="con" path="org.eclipse.jdt.junit.JUNIT_CONTAINER/5">[m
[31m-		<attributes>[m
[31m-			<attribute name="module" value="true"/>[m
[31m-		</attributes>[m
[31m-	</classpathentry>[m
[31m-	<classpathentry kind="output" path="bin"/>[m
[31m-</classpath>[m
[1mdiff --git a/.gitignore b/.gitignore[m
[1mindex ae3c172..524f096 100644[m
[1m--- a/.gitignore[m
[1m+++ b/.gitignore[m
[36m@@ -1 +1,24 @@[m
[31m-/bin/[m
[32m+[m[32m# Compiled class file[m
[32m+[m[32m*.class[m
[32m+[m
[32m+[m[32m# Log file[m
[32m+[m[32m*.log[m
[32m+[m
[32m+[m[32m# BlueJ files[m
[32m+[m[32m*.ctxt[m
[32m+[m
[32m+[m[32m# Mobile Tools for Java (J2ME)[m
[32m+[m[32m.mtj.tmp/[m
[32m+[m
[32m+[m[32m# Package Files #[m
[32m+[m[32m*.jar[m
[32m+[m[32m*.war[m
[32m+[m[32m*.nar[m
[32m+[m[32m*.ear[m
[32m+[m[32m*.zip[m
[32m+[m[32m*.tar.gz[m
[32m+[m[32m*.rar[m
[32m+[m
[32m+[m[32m# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml[m
[32m+[m[32mhs_err_pid*[m
[32m+[m[32mreplay_pid*[m
[1mdiff --git a/.project b/.project[m
[1mdeleted file mode 100644[m
[1mindex 57f17b1..0000000[m
[1m--- a/.project[m
[1m+++ /dev/null[m
[36m@@ -1,17 +0,0 @@[m
[31m-<?xml version="1.0" encoding="UTF-8"?>[m
[31m-<projectDescription>[m
[31m-	<name>ProyectoEstacion</name>[m
[31m-	<comment></comment>[m
[31m-	<projects>[m
[31m-	</projects>[m
[31m-	<buildSpec>[m
[31m-		<buildCommand>[m
[31m-			<name>org.eclipse.jdt.core.javabuilder</name>[m
[31m-			<arguments>[m
[31m-			</arguments>[m
[31m-		</buildCommand>[m
[31m-	</buildSpec>[m
[31m-	<natures>[m
[31m-		<nature>org.eclipse.jdt.core.javanature</nature>[m
[31m-	</natures>[m
[31m-</projectDescription>[m
[1mdiff --git a/.settings/org.eclipse.core.resources.prefs b/.settings/org.eclipse.core.resources.prefs[m
[1mdeleted file mode 100644[m
[1mindex 99f26c0..0000000[m
[1m--- a/.settings/org.eclipse.core.resources.prefs[m
[1m+++ /dev/null[m
[36m@@ -1,2 +0,0 @@[m
[31m-eclipse.preferences.version=1[m
[31m-encoding/<project>=UTF-8[m
[1mdiff --git a/.settings/org.eclipse.jdt.core.prefs b/.settings/org.eclipse.jdt.core.prefs[m
[1mdeleted file mode 100644[m
[1mindex 6e5f874..0000000[m
[1m--- a/.settings/org.eclipse.jdt.core.prefs[m
[1m+++ /dev/null[m
[36m@@ -1,14 +0,0 @@[m
[31m-eclipse.preferences.version=1[m
[31m-org.eclipse.jdt.core.compiler.codegen.inlineJsrBytecode=enabled[m
[31m-org.eclipse.jdt.core.compiler.codegen.targetPlatform=22[m
[31m-org.eclipse.jdt.core.compiler.codegen.unusedLocal=preserve[m
[31m-org.eclipse.jdt.core.compiler.compliance=22[m
[31m-org.eclipse.jdt.core.compiler.debug.lineNumber=generate[m
[31m-org.eclipse.jdt.core.compiler.debug.localVariable=generate[m
[31m-org.eclipse.jdt.core.compiler.debug.sourceFile=generate[m
[31m-org.eclipse.jdt.core.compiler.problem.assertIdentifier=error[m
[31m-org.eclipse.jdt.core.compiler.problem.enablePreviewFeatures=disabled[m
[31m-org.eclipse.jdt.core.compiler.problem.enumIdentifier=error[m
[31m-org.eclipse.jdt.core.compiler.problem.reportPreviewFeatures=warning[m
[31m-org.eclipse.jdt.core.compiler.release=enabled[m
[31m-org.eclipse.jdt.core.compiler.source=22[m
[1mdiff --git a/README.md b/README.md[m
[1mnew file mode 100644[m
[1mindex 0000000..aa4fccc[m
[1m--- /dev/null[m
[1m+++ b/README.md[m
[36m@@ -0,0 +1,2 @@[m
[32m+[m[32m# EstacionBrava-Integrador[m
[32m+[m[32mProyecto para la gestión de inventario y finanzas de "Estación Brava".[m
[1mdiff --git a/src/com/inventario/Inventario.java b/src/com/inventario/Inventario.java[m
[1mdeleted file mode 100644[m
[1mindex 4da4c76..0000000[m
[1m--- a/src/com/inventario/Inventario.java[m
[1m+++ /dev/null[m
[36m@@ -1,5 +0,0 @@[m
[31m-package com.inventario;[m
[31m-[m
[31m-public class Inventario {[m
[31m-[m
[31m-}[m
[1mdiff --git a/src/com/inventario/Main.java b/src/com/inventario/Main.java[m
[1mdeleted file mode 100644[m
[1mindex 5b5199a..0000000[m
[1m--- a/src/com/inventario/Main.java[m
[1m+++ /dev/null[m
[36m@@ -1,5 +0,0 @@[m
[31m-package com.inventario;[m
[31m-[m
[31m-public class Main {[m
[31m-[m
[31m-}[m
[1mdiff --git a/src/com/inventario/Reporte.java b/src/com/inventario/Reporte.java[m
[1mdeleted file mode 100644[m
[1mindex 55be1c1..0000000[m
[1m--- a/src/com/inventario/Reporte.java[m
[1m+++ /dev/null[m
[36m@@ -1,5 +0,0 @@[m
[31m-package com.inventario;[m
[31m-[m
[31m-public class Reporte {[m
[31m-[m
[31m-}[m
[1mdiff --git a/src/module-info.java b/src/module-info.java[m
[1mdeleted file mode 100644[m
[1mindex 418433d..0000000[m
[1m--- a/src/module-info.java[m
[1m+++ /dev/null[m
[36m@@ -1,8 +0,0 @@[m
[31m-/**[m
[31m- * [m
[31m- */[m
[31m-/**[m
[31m- * [m
[31m- */[m
[31m-module ProyectoEstacion {[m
[31m-}[m
\ No newline at end of file[m
