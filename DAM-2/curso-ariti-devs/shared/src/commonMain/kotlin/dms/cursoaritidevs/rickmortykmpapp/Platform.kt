package dms.cursoaritidevs.rickmortykmpapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform