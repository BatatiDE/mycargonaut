import Link from 'next/link';

export default function Home() {
    return (
        <div>
            <h1>Welcome to MyCargonaut!</h1>
            <nav>
                <Link href="login">Go to Login</Link>
                <br />
                <Link href="register">Go to Register</Link>
            </nav>
        </div>
    );
}
