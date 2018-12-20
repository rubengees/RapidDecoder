cmake_minimum_required(VERSION 3.4.1)

file(GLOB SOURCES src/main/cpp/*.cpp)
file(GLOB JPGD src/main/cpp/jpgd/*.cpp)

set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} \
                               -Wl,--gc-sections -Wl,--exclude-libs,ALL")

add_library(
        jpeg-decoder
        SHARED
        ${SOURCES}
        ${JPGD}
)

target_link_libraries(
        jpeg-decoder
        jnigraphics
)
