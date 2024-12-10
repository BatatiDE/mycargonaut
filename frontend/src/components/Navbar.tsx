"use client";

import Link from "next/link";
import { usePathname } from "next/navigation";

const Navbar = () => {
    const pathname = usePathname();

    const navItems = [
        { name: "Home", path: "/" },
        { name: "Login", path: "/login" },
        { name: "Register", path: "/register" },
        { name: "Dashboard", path: "/dashboard" },
        { name: "Search", path: "/search" },
        { name: "Offer", path: "/offer" },
        { name: "Messages", path: "/messages" },
        { name: "Tracking", path: "/tracking" },
        { name: "Reviews", path: "/reviews" },
        { name: "Payments", path: "/payments" },
    ];

    return (
        <nav className="bg-blue-600 text-white p-4 shadow-md">
            <div className="container mx-auto flex justify-between items-center">
                {/* Logo */}
                <Link href="/" className="text-xl font-bold">
                    MyCargonaut
                </Link>

                {/* Navigation Links */}
                <div className="flex gap-4">
                    {navItems.map((item) => (
                        <Link
                            key={item.name}
                            href={item.path}
                            className={`px-3 py-2 rounded ${
                                pathname === item.path
                                    ? "bg-white text-blue-600"
                                    : "hover:bg-blue-700"
                            }`}
                        >
                            {item.name}
                        </Link>
                    ))}
                </div>
            </div>
        </nav>
    );
};

export default Navbar;
