cmake_minimum_required(VERSION 3.4.1)

file(GLOB SOURCES src/main/cpp/*.cpp)
file(GLOB LIBPNG src/main/libpng/*.c)

set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} \
                               -Wl,--gc-sections -Wl,--exclude-libs,ALL")

add_library(
        png-decoder
        SHARED
        ${SOURCES} ${LIBPNG}
)

target_link_libraries(
        png-decoder
        jnigraphics
        z
)
